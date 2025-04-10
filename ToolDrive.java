import java.util.*;

public class ToolDrive {
    public static void main (String[] args)
    {
        Hammer ham = new Hammer();
        Wrench wrench = new Wrench();
        Drill drill = new Drill();

        ham.setName("Hammer");
        wrench.setName("Wrench");
        drill.setName("Drill");
        
        Toolbox<Tool> newBox = new Toolbox<>();

        Toolbox<Tool> boxList = newBox;

        newBox.add(ham);
        newBox.add(wrench);
        newBox.add(drill);

        boxList.allInOne(newBox.box);

    }
}

abstract class Tool {
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void use();
}

class Hammer extends Tool {
    public void use(){
        System.out.println("Knocking with the Hammer.");
    }
}

class Drill extends Tool {
    public void use(){
        System.out.println("Drilling with the Drill.");
    }
}

class Wrench extends Tool {
    public void use(){
        System.out.println("Wrenching with the Wrench.");
    }
}

class Toolbox<T extends Tool> {
    List<T> box = new ArrayList<>();

    public void add(T tool){
        box.add(tool);
    }

    public void listTools(List<T> tools){
        for (T tool : tools)
        {
            String name = tool.getName();
            System.out.println(name);
        }
    }

    public void useToolBox(List<T> tools){
        for (T tool : tools)
        {
            tool.use();
        }
    }

    public void allInOne(List<? extends Tool> tools){
        for (Tool tool : tools)
        {
            String name = tool.getName();
            System.out.println(name);
            tool.use();
        }
    }
}