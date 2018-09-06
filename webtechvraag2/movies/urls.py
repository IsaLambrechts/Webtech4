from django.urls import path

from . import views

app_name = 'polls'
urlpatterns = [
    path('', views.get_movies, name='get_movies'),
]
