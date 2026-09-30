#pragma once

#include <string>
#include <memory>

namespace troy {

struct artifact {
  // constructors needed (until C++20)
  artifact(std::string name) : name(name) {}
  std::string name;
};

struct power {
    // constructors needed (until C++20)
    power(std::string effect) : effect(effect) {}
    std::string effect;
};

struct human {
  std::unique_ptr<troy::artifact> possession;
  std::shared_ptr<troy::power> own_power;
  std::shared_ptr<troy::power> influenced_by;
};

void give_new_artifact(troy::human& person, std::string artifact_name);

void exchange_artifacts(std::unique_ptr<troy::artifact>& p1, std::unique_ptr<troy::artifact>& p2);

void manifest_power(troy::human& person, std::string new_power);

void use_power(troy::human& caster, troy::human& target);

int power_intensity(troy::human& person);

}  // namespace troy
