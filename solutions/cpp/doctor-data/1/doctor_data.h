
#pragma once
#include <string>

namespace star_map {

  enum class System {
      BetaHydri,
      Sol,
      EpsilonEridani,
      DeltaEridani,
      AlphaCentauri,
      Omicron2Eridani
      };
}

namespace heaven {

  class Vessel {
  public:
    Vessel(std::string name, double n, star_map::System system = star_map::System::Sol);
    std::string vessel_name;
    double generation;
    star_map::System current_system;
    Vessel replicate(std::string);
    int busters{0};
    void make_buster();
    bool shoot_buster();
  };

  std::string get_older_bob(Vessel v1, Vessel v2);
  bool in_the_same_system(Vessel v1, Vessel v2);

}
