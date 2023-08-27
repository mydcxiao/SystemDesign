import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        Scanner input = new Scanner(System.in);
        CoinTossSimulator cointoss = new CoinTossSimulator();

        System.out.print("Enter the number of trials: ");
        int num = input.nextInt();
        if (num <= 0){
            System.out.println("ERROR: Number entered must be greater than 0.");
            System.out.print("Enter the number of trials: ");
        }
        else{
            cointoss.run(num);
            frame.setSize(800, 500);
            frame.setTitle("CoinSim");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CoinSimComponent component = new CoinSimComponent(cointoss);
            frame.add(component);

            frame.setVisible(true);



        }
    }
}

