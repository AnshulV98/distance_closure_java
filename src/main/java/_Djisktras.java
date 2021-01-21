import org.javatuples.Pair;

import java.util.*;
/*

Transitive closure
===================
Computes transitive closure on a graph Adjacency Matrix.
These algorithms work with undirected weighted (distance) graphs.

 */

public class _Djisktras {

    public Pair<Map<Integer,Integer>, Map<Integer, Pair<Integer, Integer>>> single_source_shortest_distances(int source, List<Integer> N, Map<Pair<Integer,Integer>, Integer> E, Map<Integer, List<Integer>> neighbors, boolean operators, boolean verbose){
        //TODO: Look into operators as arguments for java
        /*
        Compute shortest distance between a source and all other reachable nodes.
    Args:
        source (int): the source node.
        N (list): the list of nodes in the network.
        E (dict): the dict of edges in the network.
        neighbors (dict): a dict that contains all node neighbors.
        operators (boolean): if true then max, if false then avg. TODO: can be changed to enum to accomodate more operators
        verbose (boolean): print statements as it computed shortest distances.
    Returns:
        dists (dict): the final distance calculated from source to all other nodes.
        paths (dict): the local path between source and all other nodes.
    Note:
        The python `heapq` module does not support item update.
        Therefore this algorithm keeps track of which nodes and edges have been searched already;
        and the queue itself has duplicated nodes inside.
         */

        // TODO: Understand tuples and implement accordingly

        PriorityQueue<Pair<Integer,Integer>> Q = new PriorityQueue<>();//TODO: Comparator
        Map<Integer, Integer> final_dist = new HashMap<>(); //{node:distance}
        Map<Integer, Pair<Integer, Integer>> paths = new HashMap<>(); //{node: [distance, parent_node]}
        HashSet<Integer> visited_nodes = new HashSet<>();
        HashSet<Pair<Integer,Integer>> visited_edges = new HashSet<>();

        for(int node : N){
            //Root node has distance 0
            if(node == source){
                final_dist.put(source,0);
                Q.add(new Pair<Integer, Integer>(0, node));
            }
            // All other nodes have distance infinity
            else{
                final_dist.put(node, Integer.MAX_VALUE);
                Q.add(new Pair<Integer, Integer>(Integer.MAX_VALUE,node));
            }
        }

        //Iterate over all nodes in Queue
        while(!Q.isEmpty()){
            Pair<Integer,Integer> curr = Q.poll();
            int node_dist = curr.getValue0();
            int node = curr.getValue1();

            //If node has been searched continue
            if(visited_nodes.contains(node))
                continue;

            //Iterate over all neighbors of node
            for(int neighbor : neighbors.get(node)){
                Pair<Integer,Integer> curr_edge = new Pair<>(node, neighbor);

                //if this edge has been searched continue
                if(visited_edges.contains(curr_edge))
                    continue;

                //the edge distance/weight/cost
                int weight = E.get(curr_edge);

                int new_dist = 0;
                //Operation to decide how to compute the lenght, summing edges (metric) or taking the max (ultrametric)
                if(operators)
                    new_dist = Math.max(node_dist,weight);
                else
                    new_dist = node_dist + weight;

                //if shortest distance, then update
                if(new_dist < final_dist.get(neighbor)){

                    //update shortest distance to this node
                    final_dist.put(neighbor, new_dist);

                    // update (actually include a new one) this neighbor on the queue
                    Q.add(new Pair<Integer, Integer>(new_dist, neighbor));

                    //update the path
                    paths.put(neighbor, new Pair<Integer, Integer>(new_dist, node));
                }
                visited_edges.add(curr_edge);
            }
            visited_nodes.add(node);
        }
        return new Pair<Map<Integer,Integer>, Map<Integer, Pair<Integer, Integer>>>(final_dist,paths);
    }
}
