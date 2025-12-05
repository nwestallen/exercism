(ns grade-school)

(defn grade [school grade]
  (vec (get school grade))
)

(defn add [school name grade]
  (update school grade #(vec (conj % name)))
)

(defn sorted [school]
  (into (sorted-map) (update-vals school sort))
)

