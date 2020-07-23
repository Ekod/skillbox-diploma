package skillbox.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skillbox.diploma.model.GlobalSetting;

@Repository
public interface GlobalSettingRepository extends CrudRepository<GlobalSetting, Integer> {
}
