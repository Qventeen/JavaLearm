package com.jr.level.level36.sandbox;

import com.jr.level.level36.task3604.RedBlackTree;
import com.jr.level.level36.sandbox.utils.ReflectUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.camera.Camera;

public class ViewRedBlackTree {
    public final MultiGraph graph = new MultiGraph("BaseGraph");
    private NodeWrapper current;

    public static void main(String[] args) throws Exception {
        ViewRedBlackTree view = new ViewRedBlackTree("RedBlackTree");
        RedBlackTree rt = new RedBlackTree();
        int[] testdata = new int[]{1,2,3,4,5,6,7,8,9};

        for(int i: testdata){
            rt.insert(i);
            view.drawTree(rt);
            view.stop();
        }

        rt.clear();

    }

    public void printGraph(Graph graph){
        System.out.println("Print graph nodes");
        graph.nodes().forEach(System.out::println);
        System.out.println("Print graph edges");
        graph.edges().forEach(System.out::println);

    }

    public ViewRedBlackTree(String name){
        //Установка системных свойств
        System.setProperty("org.graphstream.ui", "swing");
        System.setProperty("sun.java2d.openjl", "true");
        SwingViewer viewer = (SwingViewer) graph.display();
        Camera camera = viewer.getDefaultView().getCamera();
        camera.setAutoFitView(true);
        camera.setViewRotation(180);
        init();
    }

    public void init() {
        graph.clear();
        graph.setAttribute("ui.antialias");
        graph.setAttribute("ui.quality");
        String url = ViewRedBlackTree.class.getResource("/StyleSheet.css").toString();
        graph.setAttribute("ui.stylesheet", String.format("url('%s')", url));
    }

    public void drawTree(RedBlackTree head){
        init();
        this.current = new NodeWrapper(ReflectUtils.getPrivateField(head.getClass(),head, "header")).getRight();
        do {
            addElement(hIterator.next());
        } while(hIterator.hasNext());
    }

    //Добавляет новый элемент и связь с предком
    private void addElement(NodeWrapper element){
        //1 Добавляем новый элемент в граф
        //2 Добавить ребро
        addEdge(element, addNode(element));
    }

    private Node addNode(NodeWrapper element){
        Node node = graph.addNode(element.getElement());

        node.setAttribute("ui.class", element.getColor());
        node.setAttribute("ui.label", element.getElement());
//        sleep();
        return node;
    }

    private void addEdge(NodeWrapper element, Node node){
        if(element.getParent() != null){
            String id, parent, current;
            parent = element.getParent().getElement();
            current = element.getElement();
            id = String.format("%s%s", parent, current);

            graph.addEdge(id,parent,current, true);
        } else {
            node.setAttribute("ui.class","HEAD");
        }
//        sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(700);
        } catch (InterruptedException ignored) { }
    }

    private void stop(){
        Scanner sc = new Scanner(System.in);
        sc.next();
    }

    //Оберточный класс для RedBlackTree.Node
    private class NodeWrapper {
        private RedBlackTree.Node node;
        private String element;
        private String color;
        private NodeWrapper parent;
        private NodeWrapper left;
        private NodeWrapper right;

        public NodeWrapper(RedBlackTree.Node node){
            this.node = node;
        }

        public String getElement(){
            if(element == null){
                element = ReflectUtils.getPrivateField(node.getClass(), node, "element").toString();
            }
            return element;
        }
        public NodeWrapper getLeft(){
            if(left == null) {
                left = new NodeWrapper(ReflectUtils.getPrivateField(node.getClass(), node, "left"));
            }
            return left;
        }
        public NodeWrapper getRight(){
            if (right == null) {
                right = new NodeWrapper(ReflectUtils.getPrivateField (node.getClass(), node,"right"));
            }
            return right;
        }
        public String getColor(){
            if (color == null) {
                color = (ReflectUtils.getPrivateField(node.getClass(), node, "color").toString());
            }
            return color;
        }
        public NodeWrapper getParent() {
            return parent;
        }
        public void setParent(NodeWrapper parent) {
            this.parent = parent;
        }
    }

    //Горизонтальный обход дерева
    private final Iterator<NodeWrapper> hIterator = new Iterator<NodeWrapper>() {
        final Queue<NodeWrapper> queue = new LinkedList<>();
        NodeWrapper left = null;
        NodeWrapper right = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public NodeWrapper next() {
            left = current.getLeft();
            right = current.getRight();

            if(!"0".equals(left.getElement())){
                queue.offer(left);
                left.setParent(current);
            }

            if(!"0".equals(right.getElement())){
                queue.offer(right);
                right.setParent(current);
            }
            NodeWrapper tmp = current;
            current = queue.poll();
            return tmp;
        }
    };
}
