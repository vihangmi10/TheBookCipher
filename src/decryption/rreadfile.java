package decryption;

import java.io.*;
import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class rreadfile {
        //String lines;

      //  Scanner scan,scan1;
        ArrayList<String> strarr = new ArrayList<String>();
        ArrayList<reftxt> refarr = new ArrayList<reftxt>();
        ArrayList<reftxt1> refarr1 = new ArrayList<reftxt1>();
    
   public void fill_list(String file_name){
try{
         File fname3 = new File(file_name);
         Scanner scan2 = new Scanner(fname3);
int counts = 1;
int k = 0;

        while (scan2.hasNext()){

       String temp = scan2.nextLine();
          String[] sts = temp.split(" ");
          for(int i=0;i<sts.length;i++)
          {
             // System.out.println(sts[i]);
            }
         for(int i=0;i<sts.length;i++)
         {
             reftxt txt = new reftxt();
             txt.words = sts[i];
             txt.word_no = i+1;
             txt.line_no = counts;
                    refarr.add(k, txt);

k++;

             }
          counts++;
         }





         }catch(Exception es1){
             System.out.println(es1.getMessage());


         }
}
     public void fill_list1(String file_name){
try{
         File fname3 = new File(file_name);
         Scanner scan2 = new Scanner(fname3);
int counts = 1;
         ArrayList<String> pr = new ArrayList<String>();
         while (scan2.hasNext()){
             
       String temp = scan2.nextLine();
          String[] sts = temp.split(" ");
         int cnt5 = 1;
         for(int j=0;j<sts.length;j++){
            for(int m=0;m<sts[j].length();m++)
            {
                reftxt1 txt1 = new reftxt1();

                txt1.word = sts[j].charAt(m);
                txt1.line_no = counts;
                txt1.word_no = cnt5;
                       refarr1.add(txt1);
                cnt5++;

             }

             }
             counts++;

    }
         //for(int t=0;t<refarr1.size();t++){
    //System.out.println(refarr1.get(t).word);
    //System.out.println(refarr1.get(t).line_no);
   // System.out.println(refarr1.get(t).word_no);





         }catch(Exception es1){
             System.out.println(es1.getMessage());


         }
}
public void decrypt(String file_name,String file_name2){
    try{
    File fname3 = new File(file_name);
         Scanner scan2 = new Scanner(fname3);
        while (scan2.hasNext()){
            
       String temp = scan2.nextLine();
          String[] sts = temp.split(" ");

          for(int i=0;i<sts.length;i=i+0)
          {
              int d = Integer.parseInt(sts[i]);
              if(d == 0)
              {
                int y = Integer.parseInt(sts[i+2]);
                int z= Integer.parseInt(sts[i+3]);
                  for(int j=0;j<refarr.size();j++)
                {
                    if(refarr.get(j).line_no == y && refarr.get(j).word_no == z)
                    {
                         try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(refarr.get(j).words);
    out.print(" ");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
                    }
                }
                i = i+4;
              }

              if(d == 1)
              {
                  int h = Integer.parseInt(sts[i+1]);

                  i = i+2;

                  for(int m=0;m<h;m++)
                  {
                     int j = Integer.parseInt(sts[i]);
                     int k = Integer.parseInt(sts[i+1]);
                     for(int n=0;n<refarr1.size();n++)
                     {
                     if(refarr1.get(n).line_no == j && refarr1.get(n).word_no == k)
                    {
                         try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(refarr1.get(n).word);
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
                         break;
                         }
                    }
                     i = i+2;
                  }
                  try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(" ");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}

                  
              }

              if(d ==5)
              {
                 try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(" ");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
                 i=i+4;
              }
          }
try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.println();
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
        }
}catch(Exception es1){
             System.out.println(es1.getMessage());


         }
}

}
