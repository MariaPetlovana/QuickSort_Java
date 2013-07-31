/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Masha
 */
public class JavaApplication4 {
    
    public static class QuickSort
    {
        private ArrayList<Integer> m_list;
        
        private class MyPair
        {
            int start;                    
            int end;
        }
        
        public QuickSort(ArrayList<Integer> l, int _size)
        {
            this.m_list = l;
            Sort(0, _size - 1);
        }
        
        private ArrayList<Integer> ReturnList()
        {
            return m_list;
        }
        
        private void Sort(int start, int end)
        {
            MyPair m = Partition(start, end);
                        
            if(m.start < end)
            {
                Sort(m.start, end);
            }
            
            if(m.end > start)
            {
                Sort(start, m.end);
            }
            
            return;               
         }        
        
        private MyPair Partition(int start, int end)
        {
            MyPair Result = new MyPair();
            
            int i = start;
            int j = end;
            int x = (start + end) >> 1;
            do
            {
                while((m_list.get(i)).compareTo((m_list.get(x))) < 0)
                {
                    ++i;
                }
                while((m_list.get(j)).compareTo(m_list.get(x)) > 0)
                {
                    --j;
                }
                
                if(i <= j)
                {
                    if(i < j)
                    {
                        int tmp = (int)m_list.get(i);
                        m_list.set(i, m_list.get(j));
                        m_list.set(j, tmp);
                    }
                    
                    ++i;
                    --j;
                }
            }while(i <= j);
            
            Result.start = i;
            Result.end = j;
            
            return Result;
        }        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(5);        
        a.add(0);
        a.add(6);
        a.add(3);
        a.add(4);

        QuickSort b = new QuickSort(a, 5);
        a = b.ReturnList(); 
        
        for(Integer i : a)
        {
            System.out.println(i);
        }
    }
}
