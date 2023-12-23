package contacts;

public class Organization extends Phone{
    private String adress;

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }
    @Override
    public void show(){
        System.out.println(
                "Organization name: " + super.getName() +"\n" +
                        "Address: " + this.getAdress() + "\n" +
                        "Number: " + super.getNumber() +"\n" +
                        "Time created: " + this.getInitial() + "\n" +
                        "Time last edit: " + this.getLastEdit()
        );
    }

    public String regexTool() {
        return (
                super.getName() +"\n" +
                        this.getName() + "\n" +
                        this.getAdress() + "\n" +
                        super.getNumber() +"\n" +
                        this.getInitial() + "\n" +
                        this.getLastEdit()
        );
    }
}
