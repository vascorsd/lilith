set shell := ["bash", "-c"]

# tools bins
SEED      := 'seed-jvm'

TARGETS_ALL := 'protocol client'



### begin TASKS ###

clean-compile: clean reload build

reload:
    {{SEED}} bloop

# supply a specific TARGET to not build everything
build TARGET='all':
    @if [ {{TARGET}} == all ]; then \
        echo 'Building all targets...'; \
        {{SEED}} build {{TARGETS_ALL}}; \
    else \
        echo 'Building only specified target...'; \
        {{SEED}} build {{TARGET}}; \
    fi

# supply MODE=all really clean the workspace as if fresh git clone
clean MODE='':
    @echo 'Removing build related artifacts...'
    @rm --recursive --force --verbose build out target .target

    @if [ "{{MODE}}" == "all" ]; then \
        echo 'Removing extra stuff from workspace...'; \
        rm --recursive --force --verbose .bloop .idea .idea_modules .bsp .metals .scalafix-rules/*; \
    fi

run APP: build
    {{SEED}} run {{APP}}

### end TASKS ###



### begin SOURCE CHANGING ###
#format TARGET='all':
#    TODO

#fix TARGET='all':
#    TODO

### end SOURCE CHANGING ###



### begin CHECKING / LINTING ###

#check-format:
#    TODO

#check-fix: build
#    TODO

check-updates:
    {{SEED}} update

### end CHECKING / LINTING ###
