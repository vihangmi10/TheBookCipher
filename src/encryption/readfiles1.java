


package encryption;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.awt.Desktop;
import beproject.Encryption;
/**
 *
 * @author Rohit
 */
public class readfiles1 {


    ArrayList<reftxt> refarr = new ArrayList<reftxt>();
    
    ArrayList<reftxt1> refarr1 = new ArrayList<reftxt1>();
    ArrayList<reftxt1> refarr2 = new ArrayList<reftxt1>();
    ArrayList<String> outs = new ArrayList<String>();
   ArrayList<String> outs2 = new ArrayList<String>();
     ArrayList<String> outsp = new ArrayList<String>();
   int flag=0;
   int count =0;
    int words = 0;
String check ,all;
 //PrintWriter pw = null;
   public void readfiles1(String file_name){
       

       try{
       File fname1 = new File(file_name);
    Scanner sc = new Scanner(fname1);
 
  while (sc.hasNext()){
       String temp = sc.nextLine();
          String[] sts = temp.split(" ");
               outs.addAll(Arrays.asList(sts));

               }

              // for (int i = 0;i<outs.size();i++){
                  // System.out.println(outs.get(i));
  //}

       }catch(Exception ex){
            System.out.println(ex.getMessage());
       }
    }
    public ArrayList<String> getarrayList(){
       
        return outs;

   }
    public void readfiles2(String file_name){
try{
       File fname2 = new File(file_name);
    Scanner sc2 = new Scanner(fname2);
    all="CIPHER TEXT -";
  while (sc2.hasNext()){
       String temp = sc2.nextLine();
          String[] sts2 = temp.split(" ");
               outs2.addAll(Arrays.asList(sts2));
              
  }
// for (int i = 0;i<outs2.size();i++){
                //   System.out.println(outs2.get(i));
              // }

       }catch(Exception ex){
            System.out.println(ex.getMessage());
       }
    }

    public void cmplist(String file_name){

        try{
        for(int i=0; i<outs.size();i++){
            flag=0;
            for(int j=0;j<outs2.size();j++){
                if(outs.get(i).equals(outs2.get(j)) && flag==0)
                {
                   //* System.out.println("Word Found"+ outs.get(i));
                    check=outs.get(i);
                    File fname2 = new File(file_name);
                    Scanner scan1 = new Scanner(fname2);
                    flag=1;
                    count=0;
                    words=1;
                    while (scan1.hasNextLine()){
        count ++;
        words=1;
                    String line11 = scan1.nextLine();

        // System.out.println(" "+line);
                String[] smallword = line11.split(" ");

                for(String smwrd: smallword){

               // System.out.println(smwrd);
                if(smwrd.equals(check)){
                    //System.out.println("Word Found");
                  //*  System.out.println("No of Words in line "+ count + ":"+words);
                    all+=count+":"+words+" ";
                }
                    words ++;
                }
                    }
            }
        }

    

    }
    
        
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
   

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
       //  for(int n=0;n<refarr1.size();n++)
       // {
             // System.out.println(refarr1.get(n).line_no);
       //                   System.out.println(refarr1.get(n).word_no);
       //                    System.out.println(refarr1.get(n).word);
       //  }

        
          
         }catch(Exception es1){
             System.out.println(es1.getMessage());


         }
}
          public void fill_list2(String file_name){
try{
         File fname3 = new File(file_name);
         Scanner scan2 = new Scanner(fname3);
         int counts = 1;
        // ArrayList<String> pr = new ArrayList<String>();
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
                       refarr2.add(txt1);
                cnt5++;

             }

             }
          counts++;

    }
        // for(int n=0;n<refarr2.size();n++)
       //  {
       //       System.out.println(refarr2.get(n).line_no);
       //                  System.out.println(refarr2.get(n).word_no);
       //                    System.out.println(refarr2.get(n).word);
       //  }



         }catch(Exception es1){
             System.out.println(es1.getMessage());


         }

}

   public void encrypt(String file_name,String file_name2){


       try{
       File fname1 = new File(file_name);
    Scanner sc = new Scanner(fname1);
int checker22=0;
    for(int r=0;r<refarr2.size();r++)
    {
            int flag5=0;
           // String temp = Character.toString(refarr2.get(r).word);
        for(int s=0;s<refarr1.size();s++)
        {
            //String temp1 = Character.toString(refarr1.get(s).word);
            if(refarr1.get(s).word == refarr2.get(r).word)
            {
               checker22=checker22+1;
               flag5=1;
               break;
            }
        }
            if(flag5==0)
            {
                System.out.println(refarr2.get(r).word);
                try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.println(refarr2.get(r).word);
     out.close();
} catch (IOException e) {

    System.out.println(e.getMessage());
}
            }
    }

    if(checker22 == refarr2.size())
    {
        System.out.println("Refkey valid");

    }
    if(checker22 < refarr2.size())
    {
        System.out.println("Refkey Invalid");
         try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.println("Refkey Invalid");
     out.close();
} catch (IOException e) {

    System.out.println(e.getMessage());
}
                    Desktop desk = Desktop.getDesktop();
                    File dir = new File(file_name2);
                    
                        desk.open(dir);
                    
      
System.exit(0);
    }
    

  while (sc.hasNext()){
      
      
       String temp = sc.nextLine();
          String[] sts = temp.split(" ");
          int flag1= 0;
          
               for(int i=0;i<sts.length;i++)
              {
                   int flag = 0;
                  for(int j=0;j<refarr.size();j++)
                  {
                      if(refarr.get(j).words.equals(sts[i]))
                      {
                        //  System.out.println(refarr.get(j).line_no);
                        //  System.out.println(refarr.get(j).word_no);
                           try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(0);
    out.print(" ");
    out.print(1);
    out.print(" ");
    out.print(refarr.get(j).line_no);
    out.print(" ");
   out.print(refarr.get(j).word_no);
   out.print(" ");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
                          flag = 1;
                          flag1 =1;
                          break;
                      }
                  }
                   if(flag == 0)
                   {
                       try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(1);
    out.print(" ");
    int length = sts[i].length();
    out.print(length);
    out.print(" ");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
                       char[] temparray = new char[100];
                       for(int k=0;k<sts[i].length();k++)
                       {
                           temparray[k] = sts[i].charAt(k);

                       }

                       for(int l=0;l<temparray.length;l++)
                       {
                           for(int m=0;m<refarr1.size();m++)
                           {
                               if(refarr1.get(m).word == temparray[l])
                               {
                                    flag1=1;
                                  // System.out.println(refarr1.get(m).line_no);
                               //    System.out.println(refarr1.get(m).word_no);
                                    try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(refarr1.get(m).line_no);
    out.print(" ");
   out.print(refarr1.get(m).word_no);
   out.print(" ");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
    System.out.println(e.getMessage());
}
                                  
                                   break;
                               }
                           }
                       }
                     
                   }
                   
              }
          if(flag1==0)
          {
              try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.print(5);
    out.print(" ");
    out.print(5);
    out.print(" ");
    out.print(5);
    out.print(" ");
    out.print(5);
    out.print(" ");
     out.close();
} catch (IOException e) {

    System.out.println(e.getMessage());
}
          }
 try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file_name2, true)));
    out.println();
     out.close();
} catch (IOException e) {

    System.out.println(e.getMessage());
}
               }



       }catch(Exception ex){
            System.out.println(ex.getMessage());
       }
    }
}
