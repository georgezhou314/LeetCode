package com.company;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s=new String(temp);
            List<String> t=map.get(s);
            if(t==null){
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(s,tempList);
                res.add(tempList);
            }else{
                t.add(str);
            }
        }
        return res;
    }
    public static void main(String[] args) {
	// write your code here
        String[]str= {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams test=new GroupAnagrams();
        List<List<String>> lists = test.groupAnagrams(str);
        System.out.println(lists);
    }
}
