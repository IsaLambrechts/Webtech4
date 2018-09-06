from django.http import HttpResponseNotFound
from django.shortcuts import render
import redis

# HMSET "movies:The Godfather" actor1 "Al Pacino" actor2 "Marlon Brando" actor3 "Robert Duvall"
# HMSET "movies:Schindler's List" actor1 "Liam Neeson" actor2 "Matt Damon" actor3 "Ben Kingsley"
# HMSET "movies:Saving Private" actor1 "Ryan Tom Hanks" actor2 "Marlon Brando" actor3 "Vin Diesel"
# HMSET "movies:Back to the Future" actor1 "Michael J. Fox" actor2 "Humphrey Bogart" actor3 "Lea Thompson"
# HMSET "movies:Casablanca" actor1 "Ingrid Bergman" actor2 "Christopher Lloyd" actor3 "Peter Lorre"
# HMSET "movies:The Big Lebowski" actor1 "Julianne Moore" actor2 "Jeff Bridges" actor3 "Tara Reid"


r = redis.StrictRedis(host='localhost', port=6379, db=0)


def get_movies(request):
    movies = r.keys("movies:*")
    titles = []
    for movie in movies:
        x = movie.decode().split(':')
        titles.append(x[1])
    return render(request, 'movies/movies.html', {'movies': titles})


def post_movie(request, movie):
    actors = r.hgetall("movies:" + movie)
    print(str(actors))
    actor_names = []
    if str(actors) != '{}':
        for actor in actors:
            actor_names.append(str(actors[actor])[2:-1])
        return render(request, 'movies/actors.html', {'actors': actor_names, 'movie': movie})
    else:
        return HttpResponseNotFound('<h1>Page not found</h1>')
