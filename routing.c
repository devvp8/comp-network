#include <stdio.h>
#include <stdbool.h>
#include <limits.h>

#define MAX_NODES 5
#define INFINITY INT_MAX

int graph[MAX_NODES][MAX_NODES] = {
    {0, 1, 3, INFINITY, INFINITY},
    {1, 0, INFINITY, 2, INFINITY},
    {3, INFINITY, 0, 1, 5},
    {INFINITY, 2, 1, 0, 2},
    {INFINITY, INFINITY, 5, 2, 0}
};

int routingTable[MAX_NODES][MAX_NODES];

void initializeRoutingTable() {
    for (int i = 0; i < MAX_NODES; i++) {
        for (int j = 0; j < MAX_NODES; j++) {
            if (i == j) {
                routingTable[i][j] = 0; // Distance to self is 0
            } else {
                routingTable[i][j] = INFINITY; // Initialize distances to infinity
            }
        }
    }
}

void printRoutingTable() {
    printf("Routing Table:\n");
    for (int i = 0; i < MAX_NODES; i++) {
        for (int j = 0; j < MAX_NODES; j++) {
            printf("%d\t", routingTable[i][j]);
        }
        printf("\n");
    }
}

void distanceVectorRouting() {
    initializeRoutingTable();
    bool updated;
    do {
        updated = false;
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = 0; j < MAX_NODES; j++) {
                for (int k = 0; k < MAX_NODES; k++) {
                    if (routingTable[i][k] != INFINITY && graph[k][j] != INFINITY) {
                        int distance = routingTable[i][k] + graph[k][j];
                        if (distance < routingTable[i][j]) {
                            routingTable[i][j] = distance;
                            updated = true;
                        }
                    }
                }
            }
        }
    } while (updated);
}

int main() {
    distanceVectorRouting();
    printRoutingTable();
    
    int source = 0;
    int destination = 4;
    int shortest_distance = routingTable[source][destination];
    
    printf("Shortest distance from node %d to node %d is %d\n", source, destination, shortest_distance);
    
    return 0;
}
