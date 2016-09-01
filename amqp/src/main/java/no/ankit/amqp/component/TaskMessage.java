package no.ankit.amqp.component;

/**
 * Created by AB75448 on 01.09.2016.
 */
public class TaskMessage {

    private String value;

    public TaskMessage(){

    }

    public TaskMessage(String value){
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String url)
    {
        this.value = value;
    }
}
