"""
Name: Kaushik Varadha Rajan
Student ID: 200111140
Unity ID: kaushi

Implementation of the A* algorithm

References: https://docs.python.org/3/library/heapq.html
"""

import heapq
import sys
import math
from collections import deque


#class to store city and distance
class citynode:
	def __init__(self, city, distance):
		self.city = str(city)
		self.distance = str(distance)


#class to maintain a priority queue of paths
class PQueue:
	def __init__(self):
		self.cities=[]

	def isEmpty(self):
		if(self.cities == []):
			return True
		else:
			return False

	def push(self, city, cost):
		heapq.heappush(self.cities, (cost, city))

	def pop(self):
		return heapq.heappop(self.cities)[1]


#Empty Dictionary which will be filled with the adjacent cities in Romania.
romania = {}


#Function to make the map of Romania as a dictionary
def makedict():
	file = open("roads.txt", 'r')
	for string in file:
		line = string.split(',')
		c1 = line[0]
		c2 = line[1]
		dist = int(line[2])
		romania.setdefault(c1, []).append(citynode(c2, dist))
		romania.setdefault(c2, []).append(citynode(c1, dist))



#Function to Calculate the Heuristic Value
def calc(city1,city2):
	file = open("/Users/Kaushik/Desktop/AI - HW 1/Heuristic_Costs.txt", 'r')
	for string in file:
		if city1 in string:
			line = string.split(',')
# The multiplier value of 100 is based on the information given in the prolog file - 0.00001 degrees -> 1m ; Thus, 0.01 degrees -> 1 km
			Lat1 = float(line[1]) * 100;
			Long1 = float(line[2]) * 100;
		if city2 in string:
			line = string.split(',')
			Lat2 = float(line[1]) * 100;
			Long2 = float(line[2]) * 100;

	value = math.sqrt((Lat2 - Lat1) ** 2 + (Long2 - Long1) ** 2); 
	return value    # Distance is returned in kilometers. 


def astar(start,end,visited,path,distance):
	q = PQueue()
	q.push(start,0)
	distance[start] = 0
	expandedlist = []
	path[start] = None
	while(q.isEmpty() == False):
		current = q.pop()
		expandedlist.append(current)

		if(current == end):
			break

		for new in romania[current]:
			updatedDistance = distance[current] + int(new.distance)

			if(new.city not in distance or updatedDistance < distance[new.city]):
				distance[new.city] = updatedDistance
				priority = updatedDistance + calc(end, new.city)
				q.push(new.city, priority)
				path[new.city] = current

	
	printoutput(start,end,path,distance,expandedlist)

def printoutput(start,end,path,distance,expandedlist):
	finalpath =  []
	i = end

	while(path.get(i) != None):
		finalpath.append(i)
		i = path[i]
	finalpath.append(start)
	finalpath.reverse()
	print("Expanded nodes: "+str(expandedlist))
	print("Number of nodes expanded: "+str(len(expandedlist)))
	print("List of nodes in the solution path: "+str(finalpath))
	print("Number of nodes in the path: "+str(len(finalpath)))
	print("Total distance:: "+str(distance[end]))
	

def main():
	src = sys.argv[1]
	dst = sys.argv[2]
	
	makedict()
	visited = []
	path = {}
	distance = {}
	astar(src,dst,visited,path,distance);

if __name__=="__main__":
	main()
