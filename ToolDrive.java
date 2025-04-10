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

        boxList.allInOne(newBox.box); // Unsorted
        System.out.println();
        boxList.sortByName(newBox.box); // Sorted by name
        System.out.println();
        boxList.sortByNameReversed(newBox.box);
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

    public void display(List<? extends Tool> tools) {
        for (Tool tool : tools) {
            System.out.println(tool.getName());
            tool.use();
        }
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
    // Sorting by Name

    public void sortByName(List<? extends Tool> tools) {
        tools.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));

        // Display afterwards
        display(tools);
    }

    // Sorting in reverse.

    void sortByNameReversed(List<? extends Tool> tools) {
        tools.sort(Comparator.comparing(Tool::getName).reversed());
        display(tools);
    }
}
