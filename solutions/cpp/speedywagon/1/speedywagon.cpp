#include "speedywagon.h"

namespace speedywagon {

// Enter your code below:

// Please don't change the interface of the uv_light_heuristic function
int uv_light_heuristic(std::vector<int>* data_array) {
    double avg{};
    for (auto element : *data_array) {
        avg += element;
    }
    avg /= data_array->size();
    int uv_index{};
    for (auto element : *data_array) {
        if (element > avg) ++uv_index;
    }
    return uv_index;
}

  bool connection_check(pillar_men_sensor* sensor_pointer) {
    return sensor_pointer != nullptr;
  }

  int activity_counter(pillar_men_sensor* sensor_pointer, int size) {

    int result = 0;

    for (int i = 0; i < size; i++) {
      result += (sensor_pointer + i)->activity;
    }

    return result;

  }

  bool alarm_control(pillar_men_sensor* sensor_pointer) {
    if (!sensor_pointer) {
      return false;
    } else {
      return sensor_pointer->activity > 0;
    }
  }

  bool uv_alarm(pillar_men_sensor* sensor_pointer) {
    if (!sensor_pointer) {
      return false;
    } else {
      return uv_light_heuristic(&sensor_pointer->data) > sensor_pointer->activity;
    }
  }

}  // namespace speedywagon
