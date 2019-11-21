import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

public class Avro {

    public static void main(String[] args) throws IOException {
        DatumReader<User> userDatumReader = new SpecificDatumReader<>(User.class);
        DataFileReader<User> userDataFileReader = new DataFileReader<>(new File("users.avro"), userDatumReader);

        while (userDataFileReader.hasNext()) {
            User user = userDataFileReader.next();

            System.out.println(user);
        }
    }
}
