package contacts;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static List<Phone> phoneBook = new ArrayList<>();

    private static void add(String type){
        if (type.equals("person")){
            addPerson();
        } else if (type.equals("organization")){
            addOrganization();
        }
    }

    private static void addOrganization(){
        Organization org = new Organization();
        org.setType("person");
        System.out.println("Enter the organization name:");
        String name = scanner.nextLine();
        org.setName(name);

        System.out.println("Enter the adress:");
        String adress = scanner.nextLine();
        org.setAdress(adress);

        System.out.println("Enter the number:");
        String num = scanner.nextLine();
        String numChecked = numchecker(num);
        org.setNumber(numChecked);

        org.setInitial(LocalDateTime.now().withSecond(0).withNano(0));
        org.setLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        org.setType("organization");

        phoneBook.add(org);
        System.out.println("The record added.");
    }
    private static void addPerson(){
        Person person = new Person();
        person.setType("person");
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        person.setName(name);

        System.out.println("Enter the surname:");
        String sur = scanner.nextLine();
        person.setSurname(sur);

        System.out.println("Enter the birth date:");
        String birth = scanner.nextLine();
        if (birth.trim().equals("")){
            System.out.println("Bad birth date!");
            birth = "[no data]";
        }
        person.setBirthDate(birth);

        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        if (gender.trim().equals("")){
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        person.setGender(gender);

        System.out.println("Enter the number:");
        String num = scanner.nextLine();
        String numChecked = numchecker(num);
        person.setNumber(numChecked);

        person.setInitial(LocalDateTime.now().withSecond(0).withNano(0));
        person.setLastEdit(LocalDateTime.now().withSecond(0).withNano(0));
        person.setType("person");
        phoneBook.add(person);
        System.out.println("The record added.");
    }
    private static String numchecker(String num){
        boolean one = num.matches("([^-\\s]+|.+\\s.+|.+-.+)");
        boolean two = num.matches("\\+?[^\\\\+]*");
        boolean three = num.matches("([^()]*\\(\\w+\\)[^()]*)|[^()]+");
        boolean four = num.matches("(\\+?\\(?[A-Za-z0-9]+\\)?(?:[-\\s]?\\(?[A-Za-z0-9]{2,}\\)?)*)");
        if (one && two && three && four){
            return num;
        } else {
            System.out.println("Wrong number format!");
            return "";
        }
    }

    private static void remove(){
        if (phoneBook.size() == 0){
            System.out.println("No records to remove!");
        }else {
            list(phoneBook);
            System.out.println("Select a record:");
            int number = scanner.nextInt();
            phoneBook.remove(number - 1);
            System.out.println("The record removed!");
        }
    }


    private static void edit(Phone selected) {
        if (phoneBook.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            if (selected.getType().equals("person")) {
                editPerson(selected);
            } else if (selected.getType().equals("organization")) {
                editOrganization(selected);
            }

        }
    }

    private static void editPerson(Phone phone){
            Person selected = (Person) phone;
            System.out.println("Select a field (name, surname, birth, gender, number):");
            String field = scanner.nextLine();
            while (field.matches("\\s*")){
                field = scanner.nextLine();
            }
            switch (field) {
                case "name":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    selected.setName(name);
                    break;
                case "surname":
                    System.out.println("Enter surname:");
                    String sname = scanner.nextLine();
                    selected.setSurname(sname);
                    break;
                case "birth":
                    System.out.println("Enter the birth date:");
                    String birth = scanner.nextLine();
                    if (birth.trim().equals("")){
                        System.out.println("Bad birth date!");
                        birth = "[no data]";
                    }
                    selected.setBirthDate(birth);

                    break;
                case "number":
                    System.out.println("Enter number:");
                    String input = scanner.nextLine();
                    String num = numchecker(input);
                    selected.setNumber(num);
                    break;
                case "gender":
                    System.out.println("Enter the gender (M, F):");
                    String gender = scanner.nextLine();
                    if (gender.trim().equals("")){
                        System.out.println("Bad gender!");
                        gender = "[no data]";
                    }
                    selected.setGender(gender);
                    break;
                default:
                    System.out.println("WTF");
                    break;
            }
            System.out.println("The record updated!");



    }
    private static void editOrganization(Phone phone){
        Organization selected = (Organization) phone;
        System.out.println("Select a field (address, number):");
        String field = scanner.nextLine();
        while (field.matches("\\s*")){
            field = scanner.nextLine();
        }
        switch (field) {
            case "address":
                System.out.println("Enter address:");
                String name = scanner.nextLine();
                selected.setAdress(name);
                break;
            case "number":
                System.out.println("Enter number:");
                String input = scanner.nextLine();
                String num = numchecker(input);
                selected.setNumber(num);
                break;
            default:
                System.out.println("WTF");
                break;
        }
        System.out.println("The record updated!");



    }
    private static void count(){
        int size = phoneBook.size();
        System.out.printf("The Phone Book has %d records\n",size);
    }

    private static void list(List<Phone> phoneBook){
        int index = 1;
        for (Phone p: phoneBook){
            String num = p.getNumber();
            if (Objects.equals(num, "")) num = "[no number]";
            System.out.printf("%d. %s\n",index,p.getFull());
            index += 1;
        }
    }

    public static void info(List<Phone> phoneBook){
        list(phoneBook);
        System.out.println("[list] Enter action ([number], back):");
        int number = scanner.nextInt();
        Phone seleted = phoneBook.get(number - 1);
        seleted.show();
        record(seleted);
    }

    public static void record(Phone selected){
        System.out.println("[record] Enter action (edit, delete, menu):");
        String act = scanner.nextLine();
        while(!Objects.equals(act, "menu")) {
            switch (act) {
                case "delete":
                    remove();
                    break;
                case "edit":
                    edit(selected);
                    break;
                default:
            }
            System.out.println();
            System.out.println("[record] Enter action (edit, delete, menu):");
            act = scanner.nextLine();
        }
    }

    public static void search(List<Phone> matched){
        list(matched);
        System.out.println("[search] Enter action ([number], back, again):");
        String act = scanner.nextLine();
        if(!Objects.equals(act, "back")) {
            if (act.equals("again")) {
                searchTool();
            } else {
                int index = Integer.parseInt(act);
                record(matched.get(index - 1));
            }

        }

    }

    public static void searchTool(){
        List<Phone> matched = new ArrayList<>();
        System.out.println("Enter search query:");
        String query = scanner.nextLine();
        for (Phone p: phoneBook){
            String num = p.getNumber();
            if (Objects.equals(num, "")) num = "[no number]";
            Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(p.regexTool());
            boolean matchFound = matcher.find();
            if(matchFound) {
                matched.add(p);
            }
        }
        if (matched.size() == 1){
            System.out.println(("Found 1 result:"));
            search(matched);
        } else if (matched.size() > 1){
            System.out.println("Found " + matched.size() + " results:");
            search(matched);
        }
    }

    public static void main(String[] args) {
        System.out.println("[menu] Enter action (add, list, search, count, exit):");
        String action = scanner.nextLine();
        while(!Objects.equals(action, "exit") && !action.isBlank()){
            switch(action) {
                case "add":
                    System.out.println("Enter the type (person, organization):");
                    String type = scanner.nextLine();
                    add(type);
                    break;
                case "search":
                    searchTool();
                    break;
                case "count":
                    count();
                    break;
                case "list":
                    info(phoneBook);
                    break;
                default:
            }
            System.out.println();
            System.out.println("[menu] Enter action (add, list, search, count, exit):");
            action = scanner.nextLine();
        }
    }
}
