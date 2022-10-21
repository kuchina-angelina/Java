package homework3;

public class Main {
    public static void main(String[] args){
        Terminal terminal = new Terminal();
        MobileApplication ma = new MobileApplication();
        ATM atm = new ATM();
        Card card = new Card(12,"Vitya","Pchelkin");
        StudentCard st = new StudentCard(257,"Valera","Filatov");
        SocialCard sc = new SocialCard(23,"Kosmos","Holmagorov");
        SchoolCard school = new SchoolCard(56,"Sasha","White");
//        atm.updateBalance(school,678453);
//        ma.updateBalance(st,786453);
//        terminal.payWay(card);
//        st.payment(1000);
//        terminal.payWay(st);
//        sc.payment(900);
//        terminal.payWay(sc);
//        school.payment(8998);
//        terminal.payWay(school);

    }
}


