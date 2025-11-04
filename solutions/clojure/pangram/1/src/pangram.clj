(ns pangram
  (:require [clojure.string :as str]
            [clojure.set :as st]))

(def alphabet
  #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})

(defn pangram? [sentence]
  (st/superset? (set (str/lower-case sentence)) alphabet)
)
