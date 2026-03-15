// ERROR: FILE CORRUPTED. Please supply valid C++ Code.
#include "doctor_data.h"

heaven::Vessel::Vessel(std::string name, double n, star_map::System system) {
  vessel_name = name;
  generation = n;
  current_system = system;
}

heaven::Vessel heaven::Vessel::replicate(std::string name) {
  return Vessel(name, generation + 1, current_system);
}

void heaven::Vessel::make_buster() {
  busters += 1;
}

bool heaven::Vessel::shoot_buster() {
  if (busters > 0) {
    busters -= 1;
    return true;} else {
    return false;
  }
}

std::string heaven::get_older_bob (heaven::Vessel v1, heaven::Vessel v2) {
  if (v1.generation <= v2.generation) {
    return v1.vessel_name;
  } else {
    return v2.vessel_name;
  }
}

bool heaven::in_the_same_system (heaven::Vessel v1, heaven::Vessel v2) {
  return v1.current_system == v2.current_system;
}
