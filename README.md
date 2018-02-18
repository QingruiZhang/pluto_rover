# pluto_rover
The rover can take series of commands to travel on the planet. It will report when it encounter any obstacles.
The command include F(move forward), B(move backward), L(turn left) and R(turn right)

# future extension
I only update the status of the rover and I assume the rover itself provides a schema for acatually moving to the status that it believes it has. In practise it is more likely for the rover to only have a few method to actually move (for example, move forward 10cm, move back 10cm, turn right 90 degrees and turn left 90 degrees). In this case I cannot set y = y + 1 to move forward but need to call the actual method. In that case, the move_straight method needs to be changed.
