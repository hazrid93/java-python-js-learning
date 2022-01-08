### Virtual env setup (python default)
- to create virtual environment to avoid installing dependency on global
> python -m venv env // venv is the environment name

- install from requirement file (like maven dependencies or js package.json)
> python -m pip install -r requirements.txt

- export current setup into requirement file
> python -m pip freeze > requirements.txt

- to start virtual environtment , in project directory runs
> .\env\Scripts\activate
  to exit runs (do pip install etc inside the new shell)
> deactive 

- show python pip package location
> pip list -v

- installing a package
> pip install <package>

Note: official note at : https://docs.python.org/3/tutorial/venv.html


 ### Pipenv setup (similar to node package manager)
- selecting virtual environment python
> when running or debugging python script select the virtual python interpreter at bottom left of VSCode

- install pipenv in global (similar to npm in nodejs, this is alternative to venv python feature)
> pip install --user pipenv

- instantiate pipenv in new project
> python -m pipenv --python <python_version> // this will generate Pipfile in current project

- make sure there is Pipfile.lock (similar to package.lock in node),
  inside '[script]' we can define our own run script like package.json
> // example of Pipfile.lock
 [[source]]
 url = "https://pypi.org/simple"
 verify_ssl = true
 name = "pypi"
 
 [packages]
 flask = "*"
 simplejson = "*"
 python-dotenv = "*"
 
 [dev-packages]
 watchdog = "*"
 
 [scripts]
 start = "python -m flask run"
 
 [requires]
 python_version = "3.9"

- to run py script with virtual env
> pipenv run python server.py

- install new package into local virtual env ( this will create Pipfile)
> pipenv install <package> // similar to npm install , it will generate Pipfile if it doesnt exist

- help
> pipenv install -h

- custom run script
> 
 // in Piplock
[scripts]
start = "python -m flask run"

// and then to run
pipenv run start

- pipenv install format for versioning selection
>
 pipenv install "requests>=1.4"   # will install a version equal or larger than 1.4.0
 pipenv install "requests<=2.13"  # will install a version equal or lower than 2.13.0
 pipenv install "requests>2.19"   # will install 2.19.1 but not 2.19.0

- to run py script with virtual env
> pipenv run python server.py

- show python pip package location
 > pipenv --venv

 Note: official note at: https://pipenv.pypa.io/en/latest/basics/#importing-from-requirements-txt