package inpOut.Input;

import exceptions.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SysInputProvider implements IInputProvider{
    @Override
    public PlayerInput takeInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter targetId, x-coordinate, y-coordinate");
        String line = scanner.nextLine();

        //FutureImprovement: We can move this string line parsing logic to separate class when multiple input types are
        //supported.
        String[] s = line.split(" ");
        if (s.length != 3) {
            throw new InvalidInputException();
        }
        final int playerNum = Integer.parseInt(s[0]);
        final int targetX = Integer.parseInt(s[1]);
        final int targetY = Integer.parseInt(s[2]);

        return new PlayerInput(playerNum, targetX, targetY);
    }

    @Override
    public int takeBoardSizeInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the battlefield (N): ");
        int N = scanner.nextInt();
        return N;
    }

    @Override
    public int takeNumberOfItemInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the ships : ");
        int N = scanner.nextInt();
        return N;
    }

    @Override
    public ItemInput takeItemInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter id, size, x position PlayerA, y position PlayerA, x position PlayerB, y position PlayerB");
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        if (s.length != 5) {
            throw new InvalidInputException();
        }
        final int size = Integer.parseInt(s[0]);
        final int XA = Integer.parseInt(s[1]);
        final int YA = Integer.parseInt(s[2]);
        final int XB = Integer.parseInt(s[3]);
        final int YB = Integer.parseInt(s[4]);


        return new ItemInput(size, XA, YA, XB, YB);
    }


}
