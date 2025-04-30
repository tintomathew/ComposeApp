package com.myapp.compose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core.common.StringBlock
import com.example.core.common.UnitBlock
import com.myapp.compose.R
import com.example.core.di.model.Restaurant

@Composable
fun RestaurantList(
    names: List<Restaurant>,
    onItemClick: (Restaurant)->Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = dimensionResource(R.dimen.padding_16),
            vertical = dimensionResource(R.dimen.padding_8)
        )
    ) {
        items(
            names.size
        ) {
            RestaurantCard(item = names[it].Name, { onItemClick(names[it]) })
        }
    }
}

@Composable
fun RestaurantCard(item: String, onItemClick: UnitBlock) {
    Row(
        modifier = Modifier
            .padding(all = dimensionResource(R.dimen.padding_10)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(.6f),
            maxLines = 2,
        )
        ElevatedButton(
            modifier = Modifier.weight(.4f),
            onClick = {
                onItemClick.invoke()
            },
        ) {
            Text(
                text = stringResource(
                    id = R.string.get_details
                ),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}