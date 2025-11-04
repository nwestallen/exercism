(ns robot-name)

(def alpha [\A \B \C \D \E \F \G \H \I \J \K \L \M
            \N \O \P \Q \R \S \T \U \V \W \X \Y \Z])

(def current-names (atom #{}))

(defn generatename [namelist]
  (let [tryname
   (str
   (apply str (repeatedly 2 #(get alpha (rand-int 26))))
   (apply str (repeatedly 3 #(rand-int 10)))
   )]
   (if (contains? namelist (keyword tryname))
     (recur namelist)
     tryname)
  ))

(defn robot []
  (let [rname (generatename @current-names)]
    (swap! current-names conj (keyword rname))
    (atom {:name rname})
  )
)

(defn robot-name [robot]
  (:name @robot)
)

(defn reset-name [robot]
  (reset! robot {:name (generatename @current-names)})
)
