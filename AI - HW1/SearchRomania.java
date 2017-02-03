/* 
Name: Kaushik Varadha Rajan
Unity ID: kaushi
Student ID: 200111140
*/


import java.util.*;

class City  // Class to represent an individual city node.
{
    String CityName;
    LinkedList<City> NextCity;
}

public class SearchRomania // Class to search the given map.
{
    static boolean finished = false; // Flag to check if an iteration has ended.
    static LinkedList<City> visitedNodes = new LinkedList<City>(); // List of nodes visited. (For both BFS and DFS) 
    static Stack<City> DFSPath = new Stack<City>(); //  Path followed in DFS.
    static Queue<City> qDS = new LinkedList<City>(); // Declaring the Queue data structure for use with BFS.
    static City[] cityNode = new City[20]; // Array of city objects to represent the cities of the map. 
    static LinkedList<City> SearchRoute = new LinkedList<City>(); // The route from the source to the destination.


    static Map<City, City> map = new HashMap<City, City>(); // Using a HashMap to store the parent child pairs. 

    // Initializing city names and adjacent cities as per the map.
    public void MapPaths()
    {
        for(int i=0; i<20; i++) 
        {
            cityNode[i] = new City();
            cityNode[i].NextCity = new LinkedList<City>();
        }
    
        cityNode[0].CityName = "Neamt";
        cityNode[1].CityName = "Iasi";
        cityNode[2].CityName = "Vaslui";
        cityNode[3].CityName = "Hirsova";
        cityNode[4].CityName = "Urziceni";
        cityNode[5].CityName = "Eforie";
        cityNode[6].CityName = "Bucharest";
        cityNode[7].CityName = "Giurgiu";
        cityNode[8].CityName = "Pitesti";
        cityNode[9].CityName = "Fagaras";
        cityNode[10].CityName = "Craiova";
        cityNode[11].CityName = "Rimnicu Vilcea";
        cityNode[12].CityName = "Sibiu";
        cityNode[13].CityName = "Dobreta";
        cityNode[14].CityName = "Mehadia";
        cityNode[15].CityName = "Lugoj";
        cityNode[16].CityName = "Timisoara";
        cityNode[17].CityName = "Arad";
        cityNode[18].CityName = "Zerind";
        cityNode[19].CityName = "Oradea";
    
        // Adding adjacent cities (Alphabetic order is used to break ties, i.e. the adjacent nodes have been added in alphabetical order)
        cityNode[0].NextCity.add(cityNode[1]);
        cityNode[1].NextCity.add(cityNode[0]);
        cityNode[1].NextCity.add(cityNode[2]);
        cityNode[2].NextCity.add(cityNode[1]);
        cityNode[2].NextCity.add(cityNode[4]);
        cityNode[3].NextCity.add(cityNode[5]);
        cityNode[3].NextCity.add(cityNode[4]);
        cityNode[4].NextCity.add(cityNode[6]);
        cityNode[4].NextCity.add(cityNode[3]);
        cityNode[4].NextCity.add(cityNode[2]);
        cityNode[5].NextCity.add(cityNode[3]);
        cityNode[6].NextCity.add(cityNode[9]);
        cityNode[6].NextCity.add(cityNode[7]);
        cityNode[6].NextCity.add(cityNode[8]);
        cityNode[6].NextCity.add(cityNode[4]);
        cityNode[7].NextCity.add(cityNode[6]);
        cityNode[8].NextCity.add(cityNode[6]);
        cityNode[8].NextCity.add(cityNode[10]);
        cityNode[8].NextCity.add(cityNode[11]);
        cityNode[9].NextCity.add(cityNode[6]);
        cityNode[9].NextCity.add(cityNode[12]);
        cityNode[10].NextCity.add(cityNode[13]);
        cityNode[10].NextCity.add(cityNode[8]);
        cityNode[10].NextCity.add(cityNode[11]);
        cityNode[11].NextCity.add(cityNode[10]);
        cityNode[11].NextCity.add(cityNode[8]);
        cityNode[11].NextCity.add(cityNode[12]);
        cityNode[12].NextCity.add(cityNode[17]);
        cityNode[12].NextCity.add(cityNode[9]);
        cityNode[12].NextCity.add(cityNode[19]);
        cityNode[12].NextCity.add(cityNode[11]);
        cityNode[13].NextCity.add(cityNode[10]);
        cityNode[13].NextCity.add(cityNode[14]);
        cityNode[14].NextCity.add(cityNode[13]);
        cityNode[14].NextCity.add(cityNode[15]);
        cityNode[15].NextCity.add(cityNode[14]);
        cityNode[15].NextCity.add(cityNode[16]);
        cityNode[16].NextCity.add(cityNode[17]);
        cityNode[16].NextCity.add(cityNode[15]);
        cityNode[17].NextCity.add(cityNode[12]);
        cityNode[17].NextCity.add(cityNode[16]);
        cityNode[17].NextCity.add(cityNode[18]);
        cityNode[18].NextCity.add(cityNode[17]);
        cityNode[18].NextCity.add(cityNode[19]);
        cityNode[19].NextCity.add(cityNode[12]);
        cityNode[19].NextCity.add(cityNode[18]);
    
    }
// Function to implement Depth First Search

public void DFS(City currentNode, City finalNode)
{
    if(finished == false)
    {
        DFSPath.add(currentNode);
        visitedNodes.add(currentNode);
        if(currentNode.CityName.equals(finalNode.CityName))
        {
            finished = true;
            for(City c : DFSPath)
            {
                System.out.print(c.CityName + "->");
            }
            System.out.println();
        }
        else
        {
            for(City n : currentNode.NextCity)
            {
                if(!visitedNodes.contains(n))
                {
                    DFS(n,finalNode);
                }
            }

            DFSPath.pop();
        }

    }
}

// Function to implement Breadth First Search

public void BFS(City currentNode, City finalNode)
{
    if(!visitedNodes.contains(currentNode))
    {
        visitedNodes.add(currentNode);
    }

    if(finished == false)
    {
        for(City ch : currentNode.NextCity)
        {
            if(!visitedNodes.contains(ch))
            {
                visitedNodes.add(ch);
                qDS.add(ch);
                map.put(ch,currentNode);
            }

            if(ch.CityName.equals(finalNode.CityName))
            {
                finished = true;
                SearchRoute.add(ch);
                SearchRoute.add(currentNode);
                while(SearchRoute.getLast() != visitedNodes.get(0))
                {
                    currentNode = (City) map.get(currentNode);
                    SearchRoute.add(currentNode);
                }

                while(!SearchRoute.isEmpty())
                {
                    System.out.print(SearchRoute.removeLast().CityName + "->");
                }
                System.out.println();
                return;
            }
        }

        BFS(qDS.remove(), finalNode);
    }

}

public static void main(String[] args)
{
    SearchRomania CityObj = new SearchRomania();
    CityObj.MapPaths(); // Initialize the paths for all the cities present in the map.
    City src = new City();
    City dest = new City();

    for(int i=0; i<20; i++)
    {
        if(cityNode[i].CityName.equals(args[1]))
        {
            src = cityNode[i];
        }

        if(cityNode[i].CityName.equals(args[2]))
        {
            dest = cityNode[i];
        }
    }

    if(args[0].equals("BFS"))
    {
        System.out.println("Breadth First Search.....");
        CityObj.BFS(src,dest);
        System.out.println("Total number of nodes visited: " + visitedNodes.size());
        System.out.println("Nodes visited ");

        while(!visitedNodes.isEmpty())
           System.out.print(visitedNodes.remove().CityName + " ");
            

        System.out.println();
    }
     


    else if(args[0].equals("DFS"))
    {
        System.out.println("Depth First Search.....");
        CityObj.DFS(src,dest);
        System.out.println("Total number of nodes visited: " + visitedNodes.size());
        System.out.println("Nodes visited ");

        while(!visitedNodes.isEmpty())
            System.out.print(visitedNodes.remove().CityName + " ");
        System.out.println();
    }


    
}


}

