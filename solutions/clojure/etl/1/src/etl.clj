(ns etl)

(defn lowerseq [s]
  (map #(clojure.string/lower-case %) s))

(defn transform [source] 
  (apply merge (map #(zipmap (lowerseq (val %)) (repeat (key %))) source))
)
