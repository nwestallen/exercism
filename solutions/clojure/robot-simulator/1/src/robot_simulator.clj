(ns robot-simulator)

(def compass
  {0 :north 1 :east 2 :south 3 :west})

(def c-value
  {:north 0 :east 1 :south 2 :west 3})

(def move
  {:north #(update-in % [:coordinates :y] inc)
   :east  #(update-in % [:coordinates :x] inc)
   :south #(update-in % [:coordinates :y] dec)
   :west  #(update-in % [:coordinates :x] dec)
   })

(defn robot
  "Creates a robot at the given coordinates, facing the given direction."
  [coordinates direction]
  {:coordinates coordinates :bearing direction}
  )

(def commands
  {\R (fn [robot] (update robot :bearing #(get compass (mod (+ 1 (% c-value)) 4))))
   \L (fn [robot] (update robot :bearing #(get compass (mod (+ 3 (% c-value)) 4))))
   \A (fn [robot] (((:bearing robot) move) robot))
   }
  )

(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state]
  (reduce (fn [current act] (act current)) robot-state (map #(get commands %) instructions))
  )

