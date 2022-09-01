package jdbc;

import dao.TestTableDAO;
import model.TestTAbleEntity;

import java.util.List;
import java.util.Optional;

public class TestTAbleDAOJdbcImpl implements TestTableDAO {

    private static final String CREATE="INSERT INTO test_table (description , number) values(?,?)" ;
    private static final String FINDALL="SELECT * FROM test_table";
    private static final String FINDBYID="SELECT * FROM test_table WHERE id = ?";
    private static final String DELETEBYID="DELETE FROM test_table WHERE id = ?" ;


    @Override
    public TestTAbleEntity create(TestTAbleEntity testTAbleEntity) {















        return null;
    }

    @Override
    public List<TestTAbleEntity> findAll() {
        return null;
    }

    @Override
    public Optional<TestTAbleEntity> findByID(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
