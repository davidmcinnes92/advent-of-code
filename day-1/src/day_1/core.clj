(ns day-1.core
  (:gen-class))

(require '[clojure.string :as str])

(def input (slurp "resources/input.txt"))
(def input-test (slurp "resources/input_test.txt"))

(defn sonar-sweep []
  (def total-increases (atom 0))
  (def numbers (int-array (map #(Integer/parseInt %) (str/split-lines input)))) ;; https://ask.clojure.org/index.php/10593/read-integers-from-file-into-an-integer-array
  (def previous (atom (first numbers)))
  (doseq [x numbers]
    (println x)
    (if (> x @previous)
      (swap! total-increases inc))
    (reset! previous x))
  (println "The total increases was:" @total-increases))

(defn sonar-sweep-sliding []
  (println "To be implemented...")
  (def total-increases (atom 0))
  (def numbers (int-array (map #(Integer/parseInt %) (str/split-lines input))))
  (def previous (atom (first numbers)))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (sonar-sweep))
