#include "power_of_troy.h"

namespace troy {

  void give_new_artifact(troy::human& person, std::string artifact_name) {
    person.possession = std::make_unique<troy::artifact>(artifact_name);
  }

  void exchange_artifacts(std::unique_ptr<troy::artifact>& p1, std::unique_ptr<troy::artifact>& p2) {
    std::swap(p1,p2);
  }

  void manifest_power(troy::human& person, std::string new_power) {
    person.own_power = std::make_shared<troy::power>(new_power);
  }

  void use_power(troy::human& caster, troy::human& target) {
    target.influenced_by = caster.own_power;
  }

  int power_intensity(troy::human& person) {
    return person.own_power.use_count();
  }

}  // namespace troy
