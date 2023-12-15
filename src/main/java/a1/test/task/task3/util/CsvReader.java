package a1.test.task.task3.util;

import a1.test.task.task3.entity.Login;
import a1.test.task.task3.entity.Posting;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CsvReader {
    public static List<Login> getLoginsFromFile(String path) {
        List<Login> logins = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            // Пропускаем заголовок
            reader.readNext();
            reader.readNext();

            // Читаем строки из файла
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                logins.add(createLogin(row));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return logins;
    }

    public static List<Posting> getPostingsFromFile(String path) {
        List<Posting> postings = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(path))
                .withCSVParser(csvParser)
                .withSkipLines(2)
                .build()) {
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                if (row[0] != null) { // Проверка есть ли mat doc
                    postings.add(createPosting(row));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return postings;
    }

    private static Posting createPosting(String[] row) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Posting posting = new Posting();
        posting.setMatDoc(row[0].trim());
        posting.setItem(row[1]);
        posting.setDocDate(LocalDate.parse(row[2].trim(), dateFormatter));
        posting.setPostDate(LocalDate.parse(row[3].trim(), dateFormatter));
        posting.setMaterialDescription(row[4].trim());
        posting.setQuantity(Integer.parseInt(row[5].trim()));
        posting.setBun(row[6].trim());
        posting.setAmountLc(new BigDecimal(row[7].trim().replace(",", ".")));
        posting.setCrcy(row[8].trim());
        posting.setUsername(row[9].trim());

        return posting;
    }

    private static Login createLogin(String[] row) {
        Login login = new Login();
        login.setApplication(row[0].trim());
        login.setAppAccountName(row[1].trim());
        login.setActive(Boolean.parseBoolean(row[2].trim()));
        login.setJobTitle(row[3].trim());
        login.setDepartment(row[4].trim());
        return login;
    }


}
