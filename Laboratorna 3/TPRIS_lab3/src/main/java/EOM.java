package showDataBase;

public class EOM {

    private String company;
    private String typeProcessor;
    private String frequency;
    private String RAM;
    private String hardDrive;

    public EOM(String company, String typeProcessor, String frequency, String RAM, String hardDrive) {
        this.company = company;
        this.typeProcessor = typeProcessor;
        this.frequency = frequency;
        this.RAM = RAM;
        this.hardDrive = hardDrive;
    }
    public EOM(){}

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTypeProcessor() {
        return typeProcessor;
    }

    public void setTypeProcessor(String typeProcessor) {
        this.typeProcessor = typeProcessor;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }
}