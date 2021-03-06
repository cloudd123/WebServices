(render :theme :sky
        :title "Web Services: Flask"
        :author "Nick Rothwell"

        :slides [[:section
                  (heading "Web Services: Flask")
                  (subheading "Nick Rothwell")]

                 [:section
                  [:section
                   (heading "Features")
                   (subheading "Front-End")

                   [:ul
                    [:li "Browser-based"]
                    [:li "Run locally"]
                    [:li "Individual (session)"]
                    [:li "Connected to server (only)"]
                    [:li "Temporary Local State"]]

                   ]

                  [:section
                   (subheading "Back-End")

                   [:ul
                    [:li "Centralised server (farm)"]
                    [:li "Global state, storage"]
                    [:li "Networked, sharing"]
                    [:li "Permanent storage"]
                    [:li "Big data"]]]
                  ]

                 [:section
                  [:section
                   (heading "Technologies")

                   (subheading "Front-End")
                   [:ul
                    [:li "Browser"]
                    [:li "HTML, CSS, SVG (DOM)"]
                    [:li "Javascript"]
                    [:li "WebGL, Web Audio, ..."]
                    ]
                   ]

                  [:section
                   (subheading "Back-End")
                   [:ul
                    [:li "Content (templates, media, ...)"]
                    [:li "Databases"]
                    [:li "Content management (WordPress, ...)"]
                    [:li "Caches, data feeds, messaging, ..."]
                    [:li "Wide variety of servers (Apache, Nginx, PHP, Tomcat, IIS, ...)"]
                    [:li "Wide variety of languages (Java, Ruby, PHP, Python, Clojure, ...)"]
                    ]
                   ]
                  ]

                 [:section
                  [:section
                   (heading "Languages")
                   (subheading "Back End")

                   [:ul
                    [:li "Java"]
                    [:li "Ruby"]
                    [:li "Python"]
                    [:li "Clojure"]
                    [:li "C/C++"]
                    [:li "Perl"]
                    [:li "PHP"]
                    [:li "SQL, XML, ..."]
                    ]
                   ]

                  [:section
                   (subheading "Front End")

                   [:ul
                    [:li "HTML/CSS"]
                    [:li "Javascript"]
                    [:li.fragment "(+ Frameworks: React/JSX, jQuery, D3.js, ...)"]
                    [:li.fragment "(+ CoffeeScript, ClojureScript, ...)"]]]]

                 [:section
                  [:section
                   (heading "Flask (Revisited)")

                   [:ul
                    [:li "Standalone server"]
                    [:li "Requests served by Python " [:strong "handlers"] " (" [:i "Werkzeug"] ")" ]
                    [:li "Templating engine (" [:i "Jinja2"] ")"]]
                   ]

                  [:section
                   (include-code "app.py")]]

                 [:section
                  [:section
                   (heading "Python: Installing " [:i "virtualenv"])

                   [:ul
                    [:li (tt "virtualenv") ": create a sandboxed Python environment"]
                    [:li "Multiple Python systems - perhaps even different Python versions"]
                    [:li "Install packages as non-privileged user"]
                    [:li "Switch between environments"]]
                   ]

                  [:section
                   (heading "Python Installer Yak-Shaving")
                   (subheading "(setuptools vs. pip)")

                   [:ul
                    [:li "Need to install " (tt "virtualenv") ", using " (tt "pip")]
                    [:li "Need to install " (tt "pip") " using " (tt "easy_install")]
                    [:li "(Windows:) Need to install " (tt "easy_install")]]
                   ]

                  [:section
                   (subheading "OS X, Linux")

                   [:ul
                    [:li "OS X: " (tt "easy_install") " should be present"]
                    [:li "Linux (Ubuntu/Debian): might need " (tt "sudo apt-get install setuptools")]
                    [:li "If you don't have " (tt "pip") " then: " (tt "sudo easy_install pip")]
                    [:li "If you don't have " (tt "virtualenv") "then: " (tt "sudo pip install virtualenv")]
                    ]
                   ]

                  [:section
                   (subheading "Windows")

                   [:ul
                    [:li "Get " (tt "setuptools") " here: " (link "https://pypi.python.org/pypi/setuptools")]
                    [:li "Sort out your path environment (see next)"]
                    [:li (tt "easy_install pip")]
                    [:li (tt "pip install virtualenv")]]

                   [:p "(Or: take a chance on Python 3...)"]
                   ]

                  [:section
                   (image "win-path.png")]

                  ]

                 [:section
                  [:section
                   (heading "Using " [:i "virtualenv"])

                   [:ul
                    [:li "Create a new virtual environment (once!) with: " (tt "virtualenv venv")]
                    [:li "Activate (each session) with:"
                     [:ul
                      [:li (tt "source venv/bin/activate") " (OS X/Linux)"]
                      [:li (tt "venv\\\\Scripts\\\\activate") " (Windows)"]]]
                    [:li "(The command prompt will change)"]
                    [:li "Do stuff, including " (tt "pip") " - no " (tt "sudo") " needed"]
                    [:li "Deactivate with " (tt "deactivate")]
                   ]

                   ]]

                 [:section
                  [:section
                   (heading "Installing Flask")

                   [:ul
                    [:li "Create and activate a virtual environment"]
                    [:li (tt "pip install Flask")]]]

                  [:section
                   (subheading "Simple Flask 'Hello World'")

                   (include-code "hello-world.py")

                   ]
                  ]

                 [:section
                  [:section
                   (heading "Exercise 0")
                   (subheading "Running Flask")

                   [:p "Start up a Flask server in a virtual environment, serving a 'Hello World' page."]
                   [:p "Bonus: can you switch between Python 2 and Python 3? How could you show the version in the browser?"]

                   [:p "("
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/kick-off/HANDOUT"
                            "GitHub link")
                    ".)"]
                   ]]

                 [:section
                  [:section
                   (heading "Jinja2 Templating")

                   [:p "Flask supports dynamic web page rendering"]

                   [:ul
                    [:li "Pulling substrings from URLs"]
                    [:li "Rendering templates"]]
                   ]

                  [:section
                   (subheading "Handler for templates")

                   (include-code "run-template.py")

                   [:ul
                    [:li "Use the form " (tt "<name>") " to bind part of the URL"]
                    [:li "The handler (" (tt "index") ") takes an argument with a default value"]
                    [:li "Use " (tt "render_template") " to render a template (with keyword arguments)"]]
                   ]

                  [:section
                   (include-code "template-index.html")

                   [:p "Templates need to be in a " (tt "templates") " subdirectory"
                    " alongside the main Python script."]

                   [:p "("
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/simple-template/HANDOUT"
                            "GitHub link")
                    ".)"]

                   ]
                  ]

                 [:section
                  [:section
                   (heading "Exercise 1")
                   (subheading "Foreground and Background Colours")

                   (image "colours.png")]

                  [:section
                   [:ul
                    [:li "Implement a two-colour page"]
                    [:li "The handler takes URLs beginning " (tt "/coloured/")]
                    [:li "The colours are separated by " (tt ",")]]

                   [:p "("
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/colour-template/HANDOUT"
                            "GitHub link")
                    ".)"]]
                  ]

                 [:section
                  [:section
                   (heading "Shakespeare Revisited")
                   (image "plays-1.png")]

                  [:section
                   [:ul
                    [:li "Search term picked up from the URL"]
                    [:li "Template generates title and list of results"]
                    [:li "Formatting here is simple (" (tt "<UL>") ", " (tt "<LI>") "...)"]
                    [:li [:i "No change"] " to the core logic (" (tt "logic.py") ")"]
                    ]]

                  [:section
                   (subheading "Directory Layout")

                   (include-code "play-1-tree.txt")

                   [:p "Core logic: "
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/shakespeare/HANDOUT/flask/logic.py"
                            "GitHub link")]

                   ]

                  ]

                 [:section
                  [:section
                   (heading "Exercise 2")
                   (subheading "Shakespeare Revisited")

                   [:p "Implement the Shakespeare server."]

                   [:p "(Details "
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/shakespeare/HANDOUT/README.md"
                            "here") ".)"]
                   ]

                  [:section
                   (subheading "Bonus: Bootstrap")

                   (image "boot-shake.png")

                   [:p "The template needs to include Bootstrap support."
                    " Does the handler have to change?"]
                   ]

                  ]

                 [:section
                  [:section
                   (heading "Forms")

                   [:ul
                    [:li "Flask can deal with form posting (via an object called " (tt "request") ")"]
                    [:li "Handlers can distinguish between " (tt "GET") " and " (tt "POST")]
                    ]
                   ]

                  [:section
                   (include-code "form.html")

                   [:ul
                    [:li "Note the form action (" (tt "/index") "), method (" (tt "POST")
                     ") and field name (" (tt "term") ")"]]
                   ]

                  [:section
                   (include-code "form-handler.py")]]

                 [:section
                  [:section
                   (heading "Exercise 3")
                   (subheading "Shakespeare with Search")

                   (image "shake-form.png")]

                  [:section
                   [:ul
                    [:li "With no search term, just show the form"]
                    [:li "With a search term, show the form and results (with the search term as place-holder)"]
                    ]

                   [:p "(Code skeleton "
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/shakespeare-formed/HANDOUT/"
                            "here") ".)"]

                   ]]

                 [:section
                  [:section
                   (heading "Exercise 4")
                   (subheading "Shakespeare Multi-Search")

                   (image "shake-form-3.png")

                   ]

                  [:section
                   [:ul
                    [:li "Search for three items at once"]
                    [:li "Modify the search form to have three fields"]
                    [:li "For each play, draw a stacked progress bar"]
                    ]

                   [:p "(Detail "
                    (github "codezoners-2/WebServices/tree/master/01_running_Flask/assignments/shakespeare-formed-coloured/HANDOUT/"
                            "here") ".)"]
                   ]
                  ]


                 ])
