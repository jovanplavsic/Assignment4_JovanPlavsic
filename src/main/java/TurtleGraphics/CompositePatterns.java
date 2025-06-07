//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

import TurtleGraphics.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class CompositePatterns {

    public static Command rectangle(int width, int height) {
        List<Command> cmds = new ArrayList<>();

        cmds.add(new Trace(width));
        cmds.add(new Turn(90));
        cmds.add(new Trace(height));
        cmds.add(new Turn(90));
        cmds.add(new Trace(width));
        cmds.add(new Turn(90));
        cmds.add(new Trace(height));
        cmds.add(new Turn(90));

        return new CompositeCommand(cmds);
    }

    public static Command S(int width, int height){
        List<Command> cmds = new ArrayList<>();

         cmds.add(new Trace(width));
         cmds.add(new Turn(180));
         cmds.add(new Trace(width));
         cmds.add(new Turn(270));
         cmds.add(new Trace(width));
         cmds.add(new Turn(270));
         cmds.add(new Trace(width));
         cmds.add(new Turn(90));
         cmds.add(new Trace(width));
         cmds.add(new Turn(90));
         cmds.add(new Trace(width));

         cmds.add(new Turn(90));
         cmds.add(new Move(height));

        return new CompositeCommand(cmds);
    }

    public static Command E(int width, int height){
        List<Command> cmds = new ArrayList<>();

         cmds.add(new Trace(width));
         cmds.add(new Turn(180));
         cmds.add(new Move(width));
         cmds.add(new Turn(270));
         cmds.add(new Trace(width));

         cmds.add(new Turn(270));
         cmds.add(new Trace(width));
         cmds.add(new Turn(180));
         cmds.add(new Trace(width));

         cmds.add(new Turn(270));
         cmds.add(new Trace(width));

         cmds.add(new Turn(270));
         cmds.add(new Trace(width));

         cmds.add(new Turn(180));
         cmds.add(new Move(width));
         cmds.add(new Turn(90));
         cmds.add(new Trace(height));

        return new CompositeCommand(cmds);
    }

    public static Command Three(int width, int height){
        List<Command> cmds = new ArrayList<>();

         cmds.add(new Trace(width));

         cmds.add(new Turn(90));
         cmds.add(new Trace(width));

         cmds.add(new Turn(90));
         cmds.add(new Trace(width));
         cmds.add(new Turn(180));
         cmds.add(new Trace(width));

         cmds.add(new Turn(90));
         cmds.add(new Trace(width));

         cmds.add(new Turn(90));
         cmds.add(new Trace(width));

         cmds.add(new Turn(90));
         cmds.add(new Move(height));

        return new CompositeCommand(cmds);
    }

    public static Command Next(int width){
        List<Command> cmds = new ArrayList<>();

        cmds.add(new Turn(90));
        cmds.add(new Move(width));

        return new CompositeCommand(cmds);
    }

    public static Command SE350(int width, int height) {
        List<Command> cmds = new ArrayList<>();
        // S
        cmds.add(S(width, height));
        cmds.add(Next(width+2));
        // E
        cmds.add(E(width, height));
        cmds.add(Next(width+5));
        // 3
        cmds.add(Three(width, height));
        cmds.add(Next(width+2));
        // 5 (same as S)
        cmds.add(S(width, height));
        cmds.add(Next(width+2));
        // 0 (rectangle)
        cmds.add(rectangle(width, height));
        return new CompositeCommand(cmds);
    }
}
