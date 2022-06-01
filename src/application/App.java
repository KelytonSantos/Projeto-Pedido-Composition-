package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com os dados do cliente.");
        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Aniversário (DD/MM/YYYY): ");
        Date birthDay = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDay); //"Passei" para o lado de lá!

        System.out.println("Coloque outros dados. ");
        System.out.print("Estatus: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos items para este pedido?");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Entre com os dados do pedido #" + i);
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("Resumo de pedido: ");
        System.out.println(order);

        sc.close();
    }
}
