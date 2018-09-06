from django.shortcuts import render
import redis


# HMSET name key value key value
# The Godfather : Al Pacino, Marlon Brando, Robert Duvall
# Schindler's List : Liam Neeson, Ralph Fiennes, Ben Kingsley
# Saving Private : Ryan Tom Hanks, Matt Damon, Vin Diesel
# Back to the Future : Michael J. Fox, Christopher Lloyd, Lea Thompson
# Casablanca : Ingrid Bergman, Humphrey Bogart, Peter Lorre
# The Big Lebowski : Julianne Moore, Jeff Bridges, Tara Reid

# HMSET "movies:The Godfather" actor1 "Al Pacino" actor2 "Marlon Brando" actor3 "Robert Duvall"
# HMSET "movies:Schindler's List" actor1 "Liam Neeson" actor2 "Ralph Fiennes" actor3 "Ben Kingsley"

r = redis.StrictRedis(host='localhost', port=6379, db=0)


def get_movies(request):
    movies = r.keys("movies:*")
    titles = []
    for movie in movies:
        x = movie.decode().split(':')
        titles.append(x[1])
    return render(request, 'movies/index.html', {'movies': titles})


def post_movie(request, movie):
    return ""