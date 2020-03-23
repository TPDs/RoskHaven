package com.company;

public class Boss extends User {


    public Boss(String name, String id, String password) {
        super(name, id, password);
    }
}


//    Child child = new Child();
//
//Private Object AddChildToQueue()
//{
//    String fileName = "childData.txt";
//    try{
//    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(childQueFile));
//    os.write();
//    os.close();
//} catch (FileNotFoundException e)
//    {
//        e.printStackTrace();
//    } catch (IOException e)
//
//    {
//        e.printStackTrace();
//    }
//    System.out.println("Are you sure that the information is correct ?");
//    try
//    {
//        ObjectInputStream is = new ObjectInputStream(new FileInputStream(childQueFile));
//        try {
//            Child p = (Child) is.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
//}

// sudo
/*AddchildToQueue()
* AddChildToGarten()
* RemoveChildFromGarten()
* RemoveChildFromQueue()
* UpdateChildQueue()
* CreateWorksheet()
* EditWorksheet()
* GetSalery()? nok nice to have den her
*  */