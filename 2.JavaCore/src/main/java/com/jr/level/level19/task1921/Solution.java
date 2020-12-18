package com.jr.level.level19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* 
Хуан Хуанович
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws IOException, ParseException {
        if(args.length < 1) return;
        //подготовительная работа
        BufferedReader fin = new BufferedReader(new FileReader(args[0]));

        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
        Pattern p = Pattern.compile("\\s+\\d");
        Matcher m;
        //наполнение списка персон
        String in;
        int position;
        try {
            while(fin.ready()){
				in = fin.readLine();
				m = p.matcher(in);
				m.find();
				PEOPLE.add(
						new Person(
								in.substring(0, m.start()).trim(),
								df.parse(in.substring(m.end()-1)
								)
						)
				);
			}
        } finally {
            fin.close();
        }

    }
}
