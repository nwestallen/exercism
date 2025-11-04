(ns bird-watcher)

(def last-week 
  [0 2 5 3 7 8 4]
  )

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (conj (pop birds) (+ (peek birds) 1))
  )

(defn day-without-birds? [birds]
  (not (nil? (some #(= 0 %) birds)))
  )

(defn n-days-count [birds n]
  (reduce + (take n birds))
  )

(defn busy-days [birds]
  (count (filter #(>= % 5) birds))
  )

(defn odd-week?
  ([birds]
   (if
       (not (= (set birds) #{1 0}))
     false
     (odd-week? (first birds) (second birds) (rest (rest birds)))
     )
   )
  ([bird1 bird2 birds]
   (if
       (and (empty? birds) (= (set [bird1 bird2]) #{1 0}))
     true
     (if
         (= bird1 bird2)
       false
       (recur bird2 (first birds) (rest birds))
       )
     )
   )
  )
