### env setup
- to create virtual environment to avoid installing dependency on global
> python -m venv env // venv is the environment name

- install from requirement file (like maven dependencies or js package.json)
> python -m pip install -r requirements.txt

- export current setup into requirement file
> python -m pip freeze > requirements.txt

- install new package into local virtual env
> pipenv install <package> // note that 'pip install <package>' will do global install instead

- pipenv install format
>
pipenv install "requests>=1.4"   # will install a version equal or larger than 1.4.0
pipenv install "requests<=2.13"  # will install a version equal or lower than 2.13.0
pipenv install "requests>2.19"   # will install 2.19.1 but not 2.19.0
