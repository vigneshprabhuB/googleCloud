package com.pack.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class JavaParentClass {

	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String arg[]) {
		System.out.println("Please enter the number of lines");

		Scanner s = new Scanner(System.in);
		int numberOflines = s.nextInt();
		List<String> visitorData = new ArrayList<String>();
		java.util.List<String[]> visitorDatasubArray = new ArrayList<String[]>();
		List<HashMap<String, Object>> roomInTimeOutimeList = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> roomVisitorCount=new ArrayList<HashMap<String,Object>>();
		Set<String>roomNames=new HashSet<String>();
		System.out.println("please enter the data");

		while (numberOflines > 0) {
			Scanner s1 = new Scanner(System.in);
			String data = s1.nextLine();
			visitorData.add(data);
			numberOflines--;
		}
		// spliting the input to sub arrayy
		int totalVistor = visitorData.size();
		for (int i = 0; i < totalVistor; i++) {
			visitorDatasubArray.add(visitorData.get(i).split(" "));
		}
		// addd the intime and out time based on the rooms
		for (int o = 0; o < totalVistor; o++) {
			String[] subAray = visitorDatasubArray.get(o);
			int innerArraySize = subAray.length;
			
			for (int i = 0; i < innerArraySize; i++) {
				// validation for person
				if (i == 0) {
					if(subAray[2].equals("I")){
					int index=new JavaParentClass(). validateKeyNameInArray(roomVisitorCount,subAray[1]);
					if(index==-1){
						//if  not presentt increase visitor count to 1
						HashMap<String, Object>personscount=new HashMap<String, Object>();
						personscount.put(subAray[1], 1);
						roomNames.add(subAray[1]);
						//roomVisitorCount.remove(personscount);
						roomVisitorCount.add(personscount);
						
						
					}else{
						//add to the present increase visitor count to current value +1
						HashMap<String, Object>personscount=roomVisitorCount.get(index);
						int visitorCount=(int) personscount.get(subAray[1]);
						visitorCount=visitorCount+1;
						roomVisitorCount.remove(personscount);
						personscount.put(subAray[1], visitorCount);
						roomNames.add(subAray[1]);
						roomVisitorCount.add(personscount);
					}
				}}
				// validation for roomms if present
				if (i == 1) {
					HashMap<String, Object> intimeOutTimeObject=new HashMap<String, Object>();
					int index1=new JavaParentClass(). validateKeyNameInArray(roomInTimeOutimeList,subAray[1]);
					if(index1==-1){
						//if not present
						List<String>intimeOutTimePush=new ArrayList<String>();
						intimeOutTimePush.add(subAray[3]);
						intimeOutTimeObject.put(subAray[1], intimeOutTimePush);
						roomNames.add(subAray[1]);
						roomInTimeOutimeList.add(intimeOutTimeObject);
					}else{
					   // add to the presentt araay	
						HashMap<String, Object>rommInout=roomInTimeOutimeList.get(index1);
						List<String>intimeOutTimePush=(List<String>) rommInout.get(subAray[1]);
						intimeOutTimePush.add(subAray[3]);
						roomInTimeOutimeList.remove(rommInout);
						rommInout.put(subAray[1], intimeOutTimePush);
						roomNames.add(subAray[1]);
						roomInTimeOutimeList.add(rommInout);
					}
				}
			}
		}
		System.out.println(roomNames);
		System.out.println("roomInTimeOutimeList"+roomInTimeOutimeList);
		System.out.println("roomVisitorCount"+roomVisitorCount);
	}

	public int  validateKeyNameInArray(List<HashMap<String, Object>> listArray,String key) {
		int index=-1;
		int totalSizee=listArray.size();
		for(int j=0;j<totalSizee;j++){
			HashMap<String, Object>item=listArray.get(j);
			if(item.containsKey(key)){
				index=j;
				return j;
			}
		}
		
		return index;
	}

	

}
