package lambdademos;

import java.io.File;
import java.io.FileFilter;


public class FirstLambda {

    public static void main(String[] args) {
        
//        FileFilter filter = new FileFilter() {
//
//            @Override
//            public boolean accept(File pathname) {
//                
//                return pathname.getName().endsWith(".java");
//            }
//        };
        
        FileFilter filterLambda = (File pathname) -> 
                pathname.getName().endsWith(".java");
        
        File dir = new File("C:\\Sanjay Data Backup\\Java 8\\All_Topicwise_Programs\\Lambda");
        
        File[] files = dir.listFiles(filterLambda);
        
        for (File f : files) {
            System.out.println(f);
        }
    }
}
