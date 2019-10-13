
# Example
# ./scripts/build-app.sh Development
# ./scripts/build-app.sh Full

FLAVOR="$1"
if [[ -z "$FLAVOR" ]]; then
echo "No flavor specified, use Development flavor"
FLAVOR=Development
fi

./gradlew clean assemble${FLAVOR}Release -info
