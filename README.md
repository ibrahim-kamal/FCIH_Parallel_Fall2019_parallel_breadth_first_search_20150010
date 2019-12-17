# Breadth First Search or BFS for a Graph


Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree (See method 2 of this post). The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex.
For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. A Breadth First Traversal of the following graph is 2, 0, 3, 1.



[![N|Solid](https://media.geeksforgeeks.org/wp-content/uploads/bfs-5.png)])

### Illustration :

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs1.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs2.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs3.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs4.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs5.png)])


[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs6.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs7.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs8.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs9.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs10.png)])

[![N|Solid](https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs11.png)])

