import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner scn = new Scanner(System.in);
        NoteBook book = new NoteBook();

        while(true) {
            String in = scn.nextLine();

            switch (in) {
                case "q":
                    return;
                default:
                    book.stringAdd(in);
            }
        }
    }
}

class Note {
    String FName;
    String MName;
    String LName;
    String NickName;
    String Comment;
    NoteGroups group;
    String HomeNumber;
    String[] MobileNumber;
    String Email;
    String Skype;
    Adress adress;
    Date input_date;
    Date edit_date;

    public Note(String FName, String MName, String LName, String nickName, String comment, String homeNumber, String[] mobileNumber, String email, String skype, Adress adress) {
        this.FName = FName;
        this.MName = MName;
        this.LName = LName;
        this.NickName = nickName;
        this.Comment = comment;
        this.group = NoteGroups.user;
        this.HomeNumber = homeNumber;
        this.MobileNumber = mobileNumber;
        this.Email = email;
        this.Skype = skype;
        this.adress = adress;
        this.input_date = new Date();
        this.edit_date = new Date();
    }

    public String getName() {
        return String.format("%s %s.", this.FName, this.MName.charAt(0));   //this.FName + " " + this.MName.charAt(0) + ".";
    }

    public static Note convert(String str) {
        return new Note("", "", "", "", "", "", new String[2], "", "", Adress.convert(str));
    }

    public static boolean checkString(String str) {
        return str.matches(""); // "" "" "" "" "" "" ""-"" "" "" - ""*
    }
}

class Adress {
    int index;
    String city;
    String street;
    String build;
    int apartment;

    public Adress(int index, String city, String street, String build, int apartment) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.build = build;
        this.apartment = apartment;
    }

    public String toString() {
        return String.format("%n %s, %s, %s %s - %s.", this.index, this.city, this.street, this.build, this.apartment);
    }

    public static Adress convert(String str) {
        // try
        return new Adress(11111, "city", "street", "45/12", 10);
    }

    public static boolean checkString(String str) {
        return str.matches(""); // "" "" "" "" "" "" ""-"" "" "" - ""*
    }
}

class NoteBook {
    ArrayList<Note> list;

    public NoteBook() {
        this.list = new ArrayList<Note>();
    }

//    public void add(String FName, String MName) {
////        list.add(new Note(FName, MName));
//    }

    public void stringAdd(String str) {
        if(!Note.checkString(str)) {
            System.out.println("Не валидная строка!");
            return;
        }
        list.add(Note.convert(str));
    }
}

enum NoteGroups {
    admin,
    user
}
