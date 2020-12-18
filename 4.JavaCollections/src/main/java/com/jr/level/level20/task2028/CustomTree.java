package com.jr.level.level20.task2028;

import java.io.Serializable;
import java.util.*;


/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    /**
     * Очередь для хранения последовательности элементов
     * которая обеспечивает горизонтальное добавление в дерево
     *
     * Голова текущая точка добавления
     * Последующие элементы - последующие точки добавления
     *
     * Требует переконструирования после каждой операции удаления
     * с дерева
     * */
    private Queue<Entry<String>> queue = new LinkedList<>();
    private int countElements = 0;

    Entry<String> root;

    public CustomTree(){
        root = new Entry<>("root");
        queue.offer(root);
    }
//Supported operations
    //4 -> 1
    @Override
    public boolean add(String s) {
        //Берем из головы очереди точку добавления
        Entry<String> pointForAdd = queue.peek();
        //Создаем новый элемент
        Entry<String> tmpEntry = new Entry<>(s);
        //Добавляем родителя новому элементу
        tmpEntry.parent = pointForAdd;

        //Если возможно добавить родителю элемент слева
        if(pointForAdd.availableToAddLeftChildren){
            //Добавляем
            pointForAdd.leftChild = tmpEntry;
            //Блокируем последующее добавление
            pointForAdd.availableToAddLeftChildren = false;
        } else{
            //Иначе добавить можно только справа
            pointForAdd.rightChild = tmpEntry;
            pointForAdd.availableToAddRightChildren = false;
            //Как только добавили справа убераем текущую точку добавления
            //Из очереди
            queue.poll();
        }
        //В конце процедуры добавляем в очередь будущую точку добавления
        queue.offer(tmpEntry);

        //По определению ничего не может пойти не так
        //Элемент должен добавиться в любом случае
        countElements++;
        return true;
    }
    //4 -> 2
    //methods for implementation
    @Override
    public int size() {
        return countElements;
    }
    //4 -> 3
    public String getParent(String elementName){
        Queue<Entry<String>> searchQueue = new LinkedList<>();
        Entry<String> current;

        searchQueue.offer(root);
        String result = null;
        while(!searchQueue.isEmpty()){
            current = searchQueue.poll();
            if(current.elementName.equals(elementName))
                result = current.parent.elementName;

            if(current.leftChild != null) searchQueue.offer(current.leftChild);
            if(current.rightChild != null) searchQueue.offer(current.rightChild);
        }
        return result;
    }

    //5 -> 1
    @Override
    public boolean remove(Object o) {
        if(o == null || !(o instanceof String))
            throw new UnsupportedOperationException();
        String rmElement = (String) o;
        Entry<String> current;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            current = queue.poll();
            //Если текущий элемент == искомому
            if(current.elementName.equals(rmElement)){
                //Идем к родителю
                //Предполагаем что у каждого элемента есть родитель
                //Корень не считается так как никогда вручную
                //не добавлялся.
                Entry<String> parent = current.parent;
                //Если левый ребенок родителя == текущему элементу
                //Обнуляем данного ребенка
                if(parent.leftChild == current) parent.leftChild = null;
                //Иначе обнуляем правого
                else parent.rightChild = null;

                //После удаления необходимо выполнить коррекцию
                //информации о дереве.
                reCalcTree();
                return true;
            }else{
                //Если текущий элемент != искомому продолжаем поиск
                if(current.leftChild != null) queue.offer(current.leftChild);
                if(current.rightChild != null) queue.offer(current.rightChild);
            }
        }

        //если по итогу поисков элемент не найден
        //удалить ничего не удалось
        return false;
    }


//private section


    /**
     * Задачи метода:
     * Перепостроение очереди точек добавления
     * Переподсчет количества элементов в дереве
     * Обновления возможности иметь потомков
     *
     * Голова очереди по итогу и будет такой точкой
     *
     * Необходим для корректировки последовательности
     * добавления элементов после выполняния операций
     * удаления
     */
    private void reCalcTree(){
        Entry<String> current = root;
        //Очищаем предыдущию очередь
        queue.clear();
        countElements = 0;

        //Кладем в голову корень дерева
        queue.offer(root);
        while(!queue.isEmpty()){
            //Берем эелемент с головы без его удаления
            current = queue.peek();
            //Если добавить сюда нельзя добавляем детей для дальнейшего исследования
            if(!current.isAvailableToAddChildren()){
                if(current.leftChild != null) {
                    queue.offer(current.leftChild);
                    countElements++;
                }
                if(current.rightChild != null) {
                    queue.offer(current.rightChild);
                    countElements++;
                }
            }else {
                //Если есть места для добавления, то это либо левый либо правый элемент.
                //Если левый не пуст то кидаем в очередь
                //Иначе выходим оставляя текущию запись в голове очереди
                //как точку последующего добавления
                if(current.leftChild != null) {
                    queue.offer(current.leftChild);
                    countElements++;
                }
                //Если есть элементы для добавления покидаем метод
                return;
            }
            //Поскольку добавить сюда нечего убираем элемент с головы очереди
            queue.poll();
        }
        //Если добавлять нечего нужно оживить и перевычислить дерево
        recoverReproductionOfTree();
        reCalcTree();
    }

    /**
     *Даный метод оживаляет дерево если добавление
     * более не возможно
     * */
    private void recoverReproductionOfTree(){
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer(root);
        Entry<String> current;
        //Проходим по всему дереву
        while(!queue.isEmpty()){
            current = queue.poll();
            //Если левый ребенок пуст устанавливаем возможность добавления
            if(current.leftChild == null) current.availableToAddLeftChildren = true;
            //Иначе добавляем в обработку
            else queue.offer(current.leftChild);

            //Если правый ребенок пуст устанавливаем возможностьдобавления
            if(current.rightChild == null) current.availableToAddRightChildren = true;
            //Иначе добавляем в обработку
            else queue.offer(current.rightChild);
        }
    }


//Unsupported Index Operations
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        String elementName;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName){
            this.elementName = elementName;
            availableToAddRightChildren = true;
            availableToAddLeftChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
