package com.glovo.ttglovo.favourite_meal;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;;

/**
 * Composite Key class
 */


@Embeddable
public class UserFavMealId implements Serializable {

    @Column(name = "app_user_id")
    @NotNull
    private Long appUserId;

    @NotNull
    @Column(name = "meal_id")
    private Long mealId;


    public UserFavMealId(Long appUserId, Long mealId) {
        this.appUserId = appUserId;
        this.mealId = mealId;
    }

    public UserFavMealId() {
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFavMealId that = (UserFavMealId) o;
        return Objects.equals(appUserId, that.appUserId) && Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, mealId);
    }

    @Override
    public String toString() {
        return "UserFavMealId{" +
                "appUserId=" + appUserId +
                ", mealId=" + mealId +
                '}';
    }
}
