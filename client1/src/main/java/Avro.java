import example.avro.User;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class Avro {

    public static void main(String[] args) throws IOException {
        User user = User.newBuilder()
                .setSurname("surname")
                .setAddress("address")
                .build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<>(userDatumWriter);
        dataFileWriter.create(user.getSchema(), new File("users.avro"));
        dataFileWriter.append(user);
        dataFileWriter.close();
    }
}
